# MicroJava Compiler - Project
## University of Belgrade, Faculty of Electrical Engineering
### Course: Construction of Compilers 1
Welcome to the repository for my MicroJava Compiler project. This project is developed as part of the coursework at the University of Belgrade, Faculty of Electrical Engineering.
## Project Overview
This project involves the implementation of a full compiler for the **MicroJava** programming language — a simplified subset of Java designed for educational purposes. The compiler translates MicroJava source code into bytecode executable by the MicroJava Virtual Machine, covering all major phases of compilation.
### Key Features:
- **Lexical Analysis**: Tokenization of MicroJava source code using JFlex.
- **Syntax Analysis**: Context-free grammar parsing using CUP with full Abstract Syntax Tree (AST) construction.
- **Semantic Analysis**: Type checking, scope resolution, and symbol table management.
- **Code Generation**: Bytecode generation targeting the MicroJava Virtual Machine.
- **Error Recovery**: Syntax and semantic error recovery to continue parsing after errors.
- **Extended Language Features**: Support for enums, ternary operator (`?:`), switch/case, and for loops.
## Installation
You can clone this repository to your local development environment:
```bash
git clone https://github.com/Milanrdnvc/microjava-compiler.git
```
Import the project into Eclipse IDE: `File → Import → Existing Projects into Workspace`.

Run the compiler on a MicroJava source file:
```bash
java -cp bin:lib/* rs.ac.bg.etf.pp1.Compiler test/program.mj
```

Build the project with Ant:
```bash
ant -f build.xml
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
## License
[MIT](https://choosealicense.com/licenses/mit/)
