package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FirstTaskSolution implements FirstTask {

    private ArrayList<Vertex> graph(boolean[][] adjacencyMatrix) {
        ArrayList<Vertex> vertexArrayList = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            vertexArrayList.add(new Vertex(i));
        }
        return vertexArrayList;
    }

    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        ArrayList<Vertex> vertexArrayList = graph(adjacencyMatrix);
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        StringBuilder outString = new StringBuilder();
        queue.addLast(vertexArrayList.get(startIndex));
        queue.getFirst().setVisited(true);
        while (queue.size() > 0) {
            int thisVertexIndex = queue.getFirst().getIndex();
            queue.removeFirst();
            outString.append(thisVertexIndex).append(", ");
            for (int i = 0; i < adjacencyMatrix[thisVertexIndex].length; i++) {
                if (adjacencyMatrix[thisVertexIndex][i]) {
                    Vertex neighbour = vertexArrayList.get(i);
                    if (!neighbour.isVisited()) {
                        queue.addLast(neighbour);
                        neighbour.setVisited(true);
                    }
                }
            }
        }
        return outString.toString();
    }

    @Override
    public Boolean validateBrackets(String s) {
        char[] strArray = s.toCharArray();
        String bracketsOpen = "({[";
        String bracketsClosed = ")}]";
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String symbol = String.valueOf(strArray[i]);
            if (bracketsOpen.contains(symbol)) {
                stack.add(symbol);
            }
            if (bracketsClosed.contains(symbol)) {
                if (stack.isEmpty()) {
                    return false;
                }
                int symbolIndex = bracketsClosed.indexOf(symbol);
                if (symbolIndex == bracketsOpen.indexOf(stack.getLast())) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    @Override
    public Long polishCalculation(String s) {
        return null;
    }
}
