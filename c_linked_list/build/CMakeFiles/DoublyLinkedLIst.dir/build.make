# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.20

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /opt/local/bin/cmake

# The command to remove a file.
RM = /opt/local/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Volumes/data/4_github/crafting_interpreters/c_linked_list

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Volumes/data/4_github/crafting_interpreters/c_linked_list/build

# Include any dependencies generated for this target.
include CMakeFiles/DoublyLinkedLIst.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/DoublyLinkedLIst.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/DoublyLinkedLIst.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/DoublyLinkedLIst.dir/flags.make

CMakeFiles/DoublyLinkedLIst.dir/main.c.o: CMakeFiles/DoublyLinkedLIst.dir/flags.make
CMakeFiles/DoublyLinkedLIst.dir/main.c.o: ../main.c
CMakeFiles/DoublyLinkedLIst.dir/main.c.o: CMakeFiles/DoublyLinkedLIst.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Volumes/data/4_github/crafting_interpreters/c_linked_list/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/DoublyLinkedLIst.dir/main.c.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/DoublyLinkedLIst.dir/main.c.o -MF CMakeFiles/DoublyLinkedLIst.dir/main.c.o.d -o CMakeFiles/DoublyLinkedLIst.dir/main.c.o -c /Volumes/data/4_github/crafting_interpreters/c_linked_list/main.c

CMakeFiles/DoublyLinkedLIst.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/DoublyLinkedLIst.dir/main.c.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Volumes/data/4_github/crafting_interpreters/c_linked_list/main.c > CMakeFiles/DoublyLinkedLIst.dir/main.c.i

CMakeFiles/DoublyLinkedLIst.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/DoublyLinkedLIst.dir/main.c.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Volumes/data/4_github/crafting_interpreters/c_linked_list/main.c -o CMakeFiles/DoublyLinkedLIst.dir/main.c.s

# Object files for target DoublyLinkedLIst
DoublyLinkedLIst_OBJECTS = \
"CMakeFiles/DoublyLinkedLIst.dir/main.c.o"

# External object files for target DoublyLinkedLIst
DoublyLinkedLIst_EXTERNAL_OBJECTS =

DoublyLinkedLIst: CMakeFiles/DoublyLinkedLIst.dir/main.c.o
DoublyLinkedLIst: CMakeFiles/DoublyLinkedLIst.dir/build.make
DoublyLinkedLIst: CMakeFiles/DoublyLinkedLIst.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Volumes/data/4_github/crafting_interpreters/c_linked_list/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable DoublyLinkedLIst"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/DoublyLinkedLIst.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/DoublyLinkedLIst.dir/build: DoublyLinkedLIst
.PHONY : CMakeFiles/DoublyLinkedLIst.dir/build

CMakeFiles/DoublyLinkedLIst.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/DoublyLinkedLIst.dir/cmake_clean.cmake
.PHONY : CMakeFiles/DoublyLinkedLIst.dir/clean

CMakeFiles/DoublyLinkedLIst.dir/depend:
	cd /Volumes/data/4_github/crafting_interpreters/c_linked_list/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Volumes/data/4_github/crafting_interpreters/c_linked_list /Volumes/data/4_github/crafting_interpreters/c_linked_list /Volumes/data/4_github/crafting_interpreters/c_linked_list/build /Volumes/data/4_github/crafting_interpreters/c_linked_list/build /Volumes/data/4_github/crafting_interpreters/c_linked_list/build/CMakeFiles/DoublyLinkedLIst.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/DoublyLinkedLIst.dir/depend

