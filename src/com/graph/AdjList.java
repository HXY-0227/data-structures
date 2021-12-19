package com.graph;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 图的邻接表表示法
 * 空间复杂度：O(Vertex + Edge)  v个顶点，v个链表的引用，在加上节点的个数
 * 文档：https://gitee.com/hxy-0227/learn-note/blob/master/数据结构/图论基础/图论基础及广度优先搜索和深入优先搜索算法.md
 *
 * @author : HXY
 * @date : 2021-07-12 22:37
 **/
public class AdjList implements Graph{

    // 顶点数
    private int vertex;
    // 边数
    private int edge;
    // 二维数组表示邻接矩阵
    private LinkedList<Integer>[] adj;

    public AdjList(String fileName) {
        buildGraph(fileName);
    }

    @Override
    public void buildGraph(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file, "utf-8")) {
            vertex = scanner.nextInt();
            adj = new LinkedList[vertex];
            for (int v = 0; v < vertex; v++) {
                adj[v] = new LinkedList<>();
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
        // todo
        return null;
    }

    @Override
    public Iterator<Integer> bfs() {
        // todo
        return null;
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
