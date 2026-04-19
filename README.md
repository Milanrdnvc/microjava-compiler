# MicroJava Compiler

**University of Belgrade, Faculty of Electrical Engineering**  
**Course: Construction of Compilers (PP1)**

---

Welcome to the repository for my MicroJava Compiler project. This project is developed as part of the coursework at the University of Belgrade, Faculty of Electrical Engineering.

## Project Overview

This project involves the implementation of a full compiler pipeline for the **MicroJava** programming language — a simplified subset of Java designed for educational purposes. The compiler translates MicroJava source code into bytecode executable by the MicroJava Virtual Machine.

The implementation covers all major phases of compilation: lexical analysis, syntax analysis, semantic analysis, and code generation.

## Compiler Phases

- **Lexical Analysis** — Tokenization of source code using JFlex (`mjlexer.lex`)
- **Syntax Analysis** — Context-free grammar parsing using CUP (`mjparser.cup`) with full AST construction
- **Semantic Analysis** — Type checking, scope resolution, and symbol table management
- **Code Generation** — Bytecode generation targeting the MicroJava Virtual Machine

## Key Features

- **Data Types:** `int`, `char`, `bool`
- **Variables & Constants:** Local and global variable declarations, typed constants
- **Arrays:** Single-dimensional array support with `.length` property
- **Methods:** Full method declarations with formal parameters and return types
- **Control Flow:** `if/else`, `for` loop, `break`, `continue`, `return`
- **Switch/Case:** Integer-based switch statements
- **Enum Types:** Enumeration declarations and usage
- **Ternary Operator:** `condition ? expr1 : expr2` expressions
- **Error Recovery:** Syntax and semantic error recovery to continue parsing after errors

## Project Structure

```
microjava-compiler/
├── src/                  # Java source files
│   └── rs/ac/bg/etf/pp1/
│       ├── ast/          # AST node classes
│       ├── Compiler.java
│       ├── SemanticAnalyzer.java
│       ├── CodeGenerator.java
│       └── ...
├── spec/                 # JFlex and CUP specification files
│   ├── mjlexer.lex
│   ├── mjparser.cup
│   └── mjparser_astbuild.cup
├── lib/                  # Required libraries
│   ├── JFlex.jar
│   ├── cup_v10k.jar
│   ├── mj-runtime-1.1.jar
│   └── symboltable-1-1.jar
├── test/                 # Test MicroJava programs
│   ├── program.mj
│   └── input.txt
├── bin/                  # Compiled class files
├── config/
│   └── log4j.xml
└── build.xml
```

## Installation & Setup

### Prerequisites

- Java JDK 8 or higher
- Eclipse IDE (recommended) or Apache Ant

### Running in Eclipse

1. Clone the repository:
   ```
   git clone https://github.com/Milanrdnvc/microjava-compiler.git
   ```
2. Import the project into Eclipse: `File → Import → Existing Projects into Workspace`
3. Run `Compiler.java` as a Java application

### Running with Ant

Build the project:
```
ant -f build.xml
```

## Usage

To compile a MicroJava source file, run the `Compiler` class with the path to your `.mj` file:

```
java -cp bin:lib/* rs.ac.bg.etf.pp1.Compiler test/program.mj
```

The compiler will output a `.obj` bytecode file that can be executed on the MicroJava Virtual Machine.

## Example MicroJava Program

```java
program HelloWorld

void main() {
    int x;
    x = 5;
    print(x);
}
```

## License

MIT
