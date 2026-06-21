```markdown
# ar-tetris-mobile Development Patterns

> Auto-generated skill from repository analysis

## Overview
This skill documents the development patterns and conventions used in the `ar-tetris-mobile` repository, a Kotlin-based mobile application implementing Tetris with augmented reality features. It covers code style, file organization, import/export practices, commit conventions, and testing patterns to help maintain consistency and efficiency in collaborative development.

## Coding Conventions

### File Naming
- Use **camelCase** for file names.
  - Example: `gameLogic.kt`, `tetrisBoard.kt`

### Imports
- Use **relative imports** for referencing modules within the project.
  - Example:
    ```kotlin
    import com.example.tetris.gameLogic
    ```

### Exports
- Use **named exports** to expose specific classes or functions.
  - Example:
    ```kotlin
    // In gameLogic.kt
    class GameLogic { ... }
    ```

### Commit Messages
- Freeform commit messages, typically concise (~43 characters).
- No strict prefixes required.
  - Example:  
    ```
    Add AR support to Tetris board rendering
    ```

## Workflows

### Adding a New Feature
**Trigger:** When implementing a new game feature or AR enhancement  
**Command:** `/add-feature`

1. Create a new Kotlin file using camelCase naming.
2. Implement the feature with relative imports for dependencies.
3. Export new classes or functions using named exports.
4. Write or update relevant tests (`*.test.*` files).
5. Commit changes with a clear, concise message.
6. Open a pull request for review.

### Fixing a Bug
**Trigger:** When resolving a reported issue or bug  
**Command:** `/fix-bug`

1. Locate the affected file(s) using camelCase naming.
2. Apply the fix, ensuring code style consistency.
3. Update or add tests to cover the fix.
4. Commit with a descriptive message.
5. Push changes and open a pull request.

### Running Tests
**Trigger:** To verify code correctness before merging  
**Command:** `/run-tests`

1. Identify test files matching `*.test.*` pattern.
2. Run tests using the project's preferred method (framework unknown; refer to project docs or scripts).
3. Review test results and address any failures.

## Testing Patterns

- Test files use the `*.test.*` naming pattern, e.g., `gameLogic.test.kt`.
- The specific testing framework is unknown; check project documentation or scripts for details.
- Tests should cover new features and bug fixes.

## Commands
| Command      | Purpose                                    |
|--------------|--------------------------------------------|
| /add-feature | Start the workflow for adding a new feature|
| /fix-bug     | Begin the bug fixing workflow              |
| /run-tests   | Execute all test files                     |
```