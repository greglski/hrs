package com.hrs;

import java.util.List;

public class MyStructure implements IMyStructure {
    private List<INode> nodes;

    public MyStructure(List<INode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public INode findByCode(String code) {
        return recursiveFindByCode(nodes, code);
    }

    @Override
    public INode findByRenderer(String renderer) {
        return recursiveFindByRenderer(nodes, renderer);
    }
    /*    @Override
    public INode findByCode(String code) {
        return nodes.stream()
            .filter(node -> node.getCode().equals(code))
            .findFirst()
            .orElseGet(null);
    }*/

    /*@Override
    public INode findByRenderer(String renderer) {
        return nodes.stream()
                .filter(node -> node.getRenderer().equals(renderer))
                .findFirst()
                .orElseGet(null);
    }*/

    @Override
    public int count() {
        return nodes.size();
    }

    private INode recursiveFindByCode(List<INode> nodes, String code) {
        for (INode node : nodes) {
            if (node.getCode()
                    .equals(code)) {
                return node;
            } else {
                if (!((Node)node).getNodes().isEmpty()) {
                    return recursiveFindByCode(((Node)node).getNodes(), code);
                }
            }
        }
        return null;
    }

    private INode recursiveFindByRenderer(List<INode> nodes, String renderer) {
        for (INode node : nodes) {
            if (node.getRenderer()
                    .equals(renderer)) {
                return node;
            } else {
                if (!((Node)node).getNodes().isEmpty()) {
                    return recursiveFindByRenderer(((Node)node).getNodes(), renderer);
                }
            }
        }
        return null;
    }
}
