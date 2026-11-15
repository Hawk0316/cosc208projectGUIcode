package org.example;

import java.util.*;

public class LogicNode {

    public enum Op { VAR, AND, OR, NOT }

    private final Op op;

    private final String name;

    private final LogicNode left;

    private final LogicNode right;

    private LogicNode(Op op, String name, LogicNode left, LogicNode right) {
        this.op = op;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    // ---------- Builders ----------
    public static LogicNode var(String name) {

        return new LogicNode(Op.VAR, name, null, null);

    }

    public static LogicNode not(LogicNode child)  {

        return new LogicNode(Op.NOT, null, child, null);

    }

    public static LogicNode and(LogicNode l, LogicNode r) {

        return new LogicNode(Op.AND, null, l, r);

    }

    public static LogicNode or(LogicNode l, LogicNode r)  {

        return new LogicNode(Op.OR, null, l, r);

    }


    public static LogicNode allOf(LogicNode first, LogicNode... rest) {

        LogicNode result = first;

        for (LogicNode n : rest) {

            result = and(result, n);

        }

        return result;
    }


    public boolean eval(Map<String, Boolean> env) {
        switch (op) {
            case VAR: {

                Boolean value = env.get(name);

                if (value == null) {

                    throw new IllegalArgumentException("No value supplied for proposition " + name);

                }
                return value;
            }
            case NOT: return !left.eval(env);
            case AND: return left.eval(env) && right.eval(env);
            default:  return left.eval(env) || right.eval(env);
        }
    }


    public List<String> preorder() {
        List<String> out = new ArrayList<>();

        preorder(out);

        return out;
    }

    private void preorder(List<String> out) {
        out.add(label());

        if (left != null)  left.preorder(out);

        if (right != null) right.preorder(out);
    }


    public List<String> inorder() {
        List<String> out = new ArrayList<>();

        inorder(out);

        return out;
    }

    private void inorder(List<String> out) {
        if (op == Op.NOT) {
            out.add(label());

            left.inorder(out);

            return;
        }
        if (left != null)  left.inorder(out);

        out.add(label());

        if (right != null) right.inorder(out);
    }

    public List<String> postorder() {

        List<String> out = new ArrayList<>();

        postorder(out);

        return out;
    }

    private void postorder(List<String> out) {

        if (left != null)  left.postorder(out);

        if (right != null) right.postorder(out);

        out.add(label());
    }


    public Set<String> variables() {

        Set<String> out = new LinkedHashSet<>();

        collectVariables(out);

        return out;
    }

    private void collectVariables(Set<String> out) {

        if (op == Op.VAR) out.add(name);

        if (left != null)  left.collectVariables(out);

        if (right != null) right.collectVariables(out);
    }


    public List<String> failedPropositions(Map<String, Boolean> env) {

        List<String> out = new ArrayList<>();

        collectFailed(env, out);

        return out;
    }

    private void collectFailed(Map<String, Boolean> env, List<String> out) {
        if (op == Op.VAR) {
            if (!env.get(name)) out.add(name);
        } else if (op == Op.AND) {
            left.collectFailed(env, out);

            right.collectFailed(env, out);

        }
    }

    public String label() {
        switch (op) {

            case VAR: return name;

            case NOT: return "NOT";

            case AND: return "AND";

            default:  return "OR";

        }
    }


    @Override
    public String toString() {
        switch (op) {

            case VAR: return name;

            case NOT: return "NOT " + left;

            case AND: return "(" + left + " AND " + right + ")";

            default:  return "(" + left + " OR " + right + ")";

        }
    }
}
