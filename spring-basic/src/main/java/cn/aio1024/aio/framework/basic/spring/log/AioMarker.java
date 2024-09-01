package cn.aio1024.aio.framework.basic.spring.log;

import org.slf4j.Marker;

import java.util.Iterator;

/**
 * @author lzm
 * @desc 日志标记
 * @date 2024/08/16
 */
public class AioMarker implements Marker {
    private String name;
    public static AioMarker getMarker(){
        return new AioMarker("subscribe");
    }
    public static AioMarker getErrorMarker(){
        return new AioMarker("error");
    }
    public static AioMarker getMarker(String name){
        return new AioMarker(name);
    }
    public AioMarker(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(Marker reference) {

    }

    @Override
    public boolean remove(Marker reference) {
        return false;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public boolean hasReferences() {
        return false;
    }

    @Override
    public Iterator<Marker> iterator() {
        return null;
    }

    @Override
    public boolean contains(Marker other) {
        return false;
    }

    @Override
    public boolean contains(String name) {
        return false;
    }
}
