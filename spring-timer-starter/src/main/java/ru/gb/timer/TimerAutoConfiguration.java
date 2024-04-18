package ru.gb.timer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(TimerCustomAnnotation.class)
@ComponentScan("ru.gb")
public class TimerAutoConfiguration {
}
