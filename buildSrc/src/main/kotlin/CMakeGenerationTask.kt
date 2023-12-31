import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import javax.inject.Inject

abstract class CMakeGenerationTask @Inject constructor(
    @get:Input
    val moduleName: String,
    @get:Input
    val libraryType: String,
    @get:InputDirectory
    val sourceDirectory: DirectoryProperty,
    @get:Input
    val extraFiles: List<String>,
    @get:Input
    val dependsOn: List<String>,
    @get:Input
    val privateHeaderDirs: List<String>,
    @get:OutputFile
    val cmakeFile: File,
) : DefaultTask() {
    @TaskAction
    fun generate() {
        cmakeFile.delete()
        cmakeFile.createNewFile()
        cmakeFile.setWritable(true)

        cmakeFile.appendText(
            """
                # DO NOT EDIT
                # File generated by CMakeGenerationTask
                BuildModule(
                    NAME  "$moduleName"
                    $libraryType
                    FILES
                
            """.trimIndent(),
        )

        File(sourceDirectory.get().toString()).walk()
            .filter { it.isFile }
            .map { it.absolutePath.replace("\\", "/") }
            .forEach { cmakeFile.appendText("        ${it}\n") }
        extraFiles.forEach { cmakeFile.appendText("        ${it}\n") }

        cmakeFile.appendText("    LINKS_WITH\n")
        dependsOn.forEach { cmakeFile.appendText("        ${it}\n") }
        cmakeFile.appendText("    PRIVATE_HEADERS_DIR\n")
        privateHeaderDirs.forEach { cmakeFile.appendText("        ${it}\n") }
        cmakeFile.appendText(")\n")
    }
}
