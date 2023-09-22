import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import javax.inject.Inject

abstract class JsonParserTask @Inject constructor(
    @get:InputFile
    val parser: File,
    @get:InputFile
    val template: File,
    @get:InputFile
    val json: File,
    @get:OutputFile
    val output: File,
    @get:Input
    val pythonPath: String,
    @get:Input
    val extraArgs: List<String> = listOf(),
) : DefaultTask() {

    @TaskAction
    fun generate() {
        val commandLine = mutableListOf<String>(
            "python3", parser.absolutePath, "android",
            "--json", json.absolutePath,
            "--template", template.absolutePath,
            "--output", output.absolutePath,
        )

        commandLine.addAll(extraArgs)

        println(commandLine.joinToString(" "))

        val processBuilder = ProcessBuilder(commandLine).redirectError(ProcessBuilder.Redirect.PIPE)
        processBuilder.environment()["PYTHONPATH"] = pythonPath

        val process = processBuilder.start()
        val status = process.waitFor()

        if (status != 0) {
            process.errorStream.bufferedReader().lines().forEach { println(it) }
            throw GradleException("Failed to generate $output")
        }
    }
}
