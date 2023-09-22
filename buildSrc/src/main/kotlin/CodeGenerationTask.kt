import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import javax.inject.Inject

abstract class CodeGenerationTask @Inject constructor(
    @get:InputFile
    val parser: File,
    @get:InputFile
    val codegenListFile: File,
    @get:InputFiles
    val inputFiles: List<File>,
    @get:InputFiles
    val codegenSourceFiles: ConfigurableFileTree,
    @get:Input
    val options: List<String>,
    @get:Input
    val pythonPath: String,
    @get:OutputDirectory
    val cppGeneratedDir: DirectoryProperty,
    @get:OutputDirectory
    val javaGeneratedDir: DirectoryProperty,
    @get:Input
    val bindingsFileName: String,
) : DefaultTask() {

    @TaskAction
    fun generate() {
        println("Running CodeGenerationTask")

        // clean up the generated directories so previous builds don't pollute
        println("Cleaning ${cppGeneratedDir.get()}")
        cppGeneratedDir.get().asFile.deleteRecursively()
        println("Cleaning ${javaGeneratedDir.get()}")
        javaGeneratedDir.get().asFile.deleteRecursively()

        val commandLine = mutableListOf("python3", parser.absolutePath)
        commandLine.addAll(options)

        if (bindingsFileName.isNotEmpty()) {
            commandLine.add("--input_file=$bindingsFileName")

            val bindings = File(bindingsFileName)
            bindings.delete()
            bindings.createNewFile()
            bindings.setWritable(true)

            for (file in inputFiles) {
                if (!file.path.endsWith(".h")) {
                    throw GradleException("Failed CodeGenerationTask.  $file should not be passed to codegen")
                }
                if (file.name.endsWith("ViewModel.h") && !file.name.startsWith("I")) {
                    throw GradleException("Failed CodeGenerationTask.  Only the Interface header for the ViewModel should be included, not $file")
                }
            }

            bindings.writeText(inputFiles.joinToString(";"))
        }

        println(commandLine.joinToString(" "))

        val processBuilder = ProcessBuilder(commandLine).redirectError(ProcessBuilder.Redirect.PIPE).redirectOutput(ProcessBuilder.Redirect.INHERIT)

        processBuilder.environment()["PYTHONPATH"] = pythonPath

        val process = processBuilder.start()
        process.waitFor()

        val lines = process.errorStream.bufferedReader().readLines()
        if (!lines.isEmpty()) {
            lines.forEach { println(it) }
            throw GradleException("Failed CodeGenerationTask")
        }
    }
}
