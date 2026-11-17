# Student Management System

A simple console app (Java 8) to manage students in memory.
Used to train new team members on the project workflow and Git.

## Requirements
- JDK 8
- Eclipse IDE

## Import in Eclipse
1. File > Import > General > Existing Projects into Workspace
2. Select the project folder > Finish

> **Unbound JRE?** Window > Preferences > Java > Installed JREs > Execution Environments,
> then link `JavaSE-1.8` to your JDK.

## Eclipse Files
| File | Purpose |
|---|---|
| `.project` | Tells Eclipse this is a Java project and its name |
| `.classpath` | Source folder (`src`), output folder (`bin`) and Java version (JavaSE-1.8) |
| `.settings/org.eclipse.core.resources.prefs` | File encoding (UTF-8) |
| `.settings/org.eclipse.jdt.core.prefs` | Compiler version (1.8) |

These files are committed because they have no machine-specific paths.
`bin/` is not committed (build output).

