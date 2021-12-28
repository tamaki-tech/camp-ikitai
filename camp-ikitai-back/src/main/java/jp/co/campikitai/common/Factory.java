package jp.co.campikitai.common;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Factory {
    private final ModelMapper mapper;

    public <D> D map(Object src, Class<D> dstType) {
        return mapper.map(src, dstType);
    }

    public <D> List<D> map(List<?> srcs, Class<D> dstType) {
        return srcs.stream().map(src -> map(src, dstType)).collect(Collectors.toList());
    }

    public <D> Set<D> map(Set<?> srcs, Class<D> dstType) {
        return srcs.stream().map(src -> map(src, dstType)).collect(Collectors.toSet());
    }
}
