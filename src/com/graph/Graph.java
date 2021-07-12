package com.graph;

import java.util.Iterator;

public interface Graph {

    /**
     * 通过一个txt文档构建图
     * @param fileName fileName
     */
    void buildGraph(String fileName);

    /**
     * 获取顶点数
     * @return 顶点数
     */
    int getVertex();

    /**
     * 获取边数
     * @return 边数
     */
    int getEdge();

    /**
     * 判断两顶点是否相邻
     * @param vertex1 vertex1
     * @param vertex2 vertex2
     * @return true: 相邻 false: 不相邻
     */
    boolean isAdjacent(int inputVertex1, int inputVertex2);

    /**
     * 获取顶点vertex所有相邻顶点的集合
     * @param vertex vertex
     * @return 顶点vertex所有相邻顶点的集合
     */
    Iterator<Integer> getAdjacentVertex(int inputVertex);

    /**
     * 获取顶点的度
     * @param vertex vertex
     * @return vertex的度
     */
    int degree(int inputVertex1);

    /**
     * 深度优先遍历
     * @return 遍历结果
     */
    Iterator<Integer> dfs();
}
