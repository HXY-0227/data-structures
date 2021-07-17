package com.graph;

import com.tree.BST.BST;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 邻接表表示方法，用红黑树代替链表实现
 *
 * @author : HXY
 * @date : 2021-07-12 23:29
 **/
public class AdjSet implements Graph{

    // 顶点数
    private int vertex;
    // 边数
    private int edge;
    // 二维数组表示邻接矩阵
    private TreeSet<Integer>[] adj;

    private final boolean[] dfsVisited;

    private final boolean[] bfsVisited;

    private final List<Integer> dfsResult;

    private final List<Integer> bfsResult;

    public AdjSet(String fileName) {
        buildGraph(fileName);
        dfsVisited = new boolean[vertex];
        bfsVisited = new boolean[vertex];
        dfsResult = new ArrayList<>();
        bfsResult = new ArrayList<>();
    }

    @Override
    public void buildGraph(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file, "utf-8")) {
            vertex = scanner.nextInt();
            adj = new TreeSet[vertex];
            for (int v = 0; v < vertex; v++) {
                adj[v] = new TreeSet<>();
            }

            edge = scanner.nextInt();
            for (int e = 0; e < edge; e++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getVertex() {
        return vertex;
    }

    @Override
    public int getEdge() {
        return edge;
    }

    @Override
    public boolean isAdjacent(int inputVertex1, int inputVertex2) {
        return adj[inputVertex1].contains(inputVertex2);
    }

    @Override
    public Iterator<Integer> getAdjacentVertex(int inputVertex) {
        return adj[inputVertex].iterator();
    }

    @Override
    public int degree(int inputVertex) {
        return adj[inputVertex].size();
    }

    @Override
    public Iterator<Integer> dfs() {
        return dfs(0);
    }

    private Iterator<Integer> dfs(int inputVertex) {
        dfsVisited[inputVertex] = true;
        dfsResult.add(inputVertex);
        for (Iterator<Integer> it = getAdjacentVertex(inputVertex); it.hasNext(); ) {
            int next = it.next();
            if (!dfsVisited[next]) {
                dfs(next);
            }
        }
        return dfsResult.iterator();
    }

    @Override
    public Iterator<Integer> bfs() {
        return bfs(0);
    }

    private Iterator<Integer> bfs(int inputVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(inputVertex);
        bfsVisited[inputVertex] = true;
        while (!queue.isEmpty()) {
            Integer remove = queue.remove();
            bfsResult.add(remove);
            for (Iterator<Integer> it = getAdjacentVertex(remove); it.hasNext(); ) {
                Integer next = it.next();
                if (!bfsVisited[next]) {
                    queue.add(next);
                    bfsVisited[next] = true;
                }
            }
        }
        return bfsResult.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("v = %d, e = %d %n", vertex, edge));
        for (int v = 0; v < vertex; v++) {
            sb.append(String.format("%d : ", v));
            for (int w : adj[v]) {
                sb.append(String.format("%d ",w));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
