package com.hrs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node implements ICompositeNode {
    private String code;
    private String renderer;
    private List<INode> nodes;

    public Node(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
        this.nodes = new ArrayList<>();
    }

    public void addNode(INode node) {
        nodes.add(node);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }

    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "Node{" +
                "code='" + code + '\'' +
                ", renderer='" + renderer + '\'' +
                ", nodes=" + nodes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(code, node.code) &&
                Objects.equals(renderer, node.renderer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, renderer);
    }
}
