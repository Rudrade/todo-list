package me.rudrade.todo_list.util;

import org.springframework.core.convert.converter.Converter;

import me.rudrade.todo_list.service.filter.TaskListFilter;

public class StringToEnumConverter implements Converter<String, TaskListFilter> {

    @Override
    public TaskListFilter convert(String source) {
        if (source == null) return null;

        return TaskListFilter.valueOf(source.toUpperCase());
    }

}
