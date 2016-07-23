################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../Lab1p2.cpp \
../Lab1p3.cpp \
../MyLab_1.cpp 

OBJS += \
./Lab1p2.o \
./Lab1p3.o \
./MyLab_1.o 

CPP_DEPS += \
./Lab1p2.d \
./Lab1p3.d \
./MyLab_1.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


