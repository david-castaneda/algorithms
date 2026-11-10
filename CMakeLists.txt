cmake_minimum_required(VERSION 3.20)
project(algorithms CXX)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_BUILD_TYPE Debug)
set(CMAKE_EXPORT_COMPILE_COMMANDS ON)   # lets clangd/VS Code see your flags

add_compile_options(-Wall -Wextra -fsanitize=address,undefined)
add_link_options(-fsanitize=address,undefined)

# One executable per file in leetcode/, named after the file
file(GLOB PROBLEMS CONFIGURE_DEPENDS leetcode/*.cpp linked_lists/*.cpp cpp-ds/*.cpp)
foreach(src ${PROBLEMS})
  get_filename_component(name ${src} NAME_WE)
  add_executable(${name} ${src})
  target_include_directories(${name} PRIVATE cpp-common)
  add_custom_target(run-${name} COMMAND ${name} DEPENDS ${name} USES_TERMINAL)
endforeach()