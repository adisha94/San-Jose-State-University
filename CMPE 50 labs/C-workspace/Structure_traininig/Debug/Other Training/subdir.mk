################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../Other\ Training/Main.cpp 

OBJS += \
./Other\ Training/Main.o 

CPP_DEPS += \
./Other\ Training/Main.d 


# Each subdirectory must supply rules for building sources it contributes
Other\ Training/Main.o: ../Other\ Training/Main.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"Other Training/Main.d" -MT"Other\ Training/Main.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


