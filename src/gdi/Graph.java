package gdi;

import java.util.*;

public class Graph {
 
    String[] vertices;
    Integer[][] edges;
    
    void addVertex(String label) {
        if(vertices== null) {
            vertices = new String[1];
            vertices[0] = label;
            edges = new Integer [1][1];
        }else {
            String[] oldvertices = vertices;
            vertices = new String[vertices.length+1];
            for(int i=0; i < oldvertices.length;i++) {
                vertices[i] = oldvertices[i];     
            }
            vertices[vertices.length-1] = label;
          
            Integer[][] oldedges = edges;
            edges = new Integer[vertices.length][vertices.length];
            for(int i=0; i < oldvertices.length;i++) {
                for(int j=0; j < oldvertices.length;j++) {
                    edges[i][j] = oldedges[i][j];
                }
            }
            
        }

    }

    void addEdge(String a, String b, int value) {
        edges[getVertex(a)][getVertex(b)] = value;
    }
    void removeEdge(String a, String b) {
        edges[getVertex(a)][getVertex(b)] = null;
    }
    int getVertex(String label) {
        for (int i=0 ; i< vertices.length;i++) {
            if(vertices[i] .equals (label)) {
                return i;
            }
        }return -1;
    }
    
    String depthFirstSearch(String start) {
        return dfs(getVertex(start),new List());
    }

     String dfs(int current, List used) {
         if(used.contains(current)) {
             return "";
         }
         else {
             used.add(current);
             String result = vertices[current];
             int[] nextvertices = getnextvertices(current);
             for(int i = 0; i<nextvertices.length;i++) {
                 result = result + dfs(nextvertices[i],used); 
             }
             return result;
         }
    }
     
     String breadthFirstSearch(String start) {
        String result = "";
        List used = new List();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(getVertex(start));
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(!used.contains(current)) {
                used.add(current);
                result = result + vertices[current];
                int[] nextvertices = getnextvertices(current);
                for(int i = 0; i<nextvertices.length;i++) {
                    queue.offer(nextvertices[i]);
                }
            }
        }
        return result;
     }
     
     Integer[] dijkstra(String start) {
         Integer[][] table = new Integer[vertices.length][vertices.length];
         int current = getVertex(start);
         table[0][current]=0;
         List used = new List();
        
         for(int i = 1; i < vertices.length; i++) {
             used.add(current);
             int[] nextVertices = getnextvertices(current); 
             for( int j = 0; j < nextVertices.length; j++)
             {
                 int next = nextVertices[j];
                 int distance = table[i-1][current] + edges[current][next];
                 if(table[i][next]==null || table[i][next] > distance) {
                     table[i][next] = distance;
                     
                 }
             }
             current = nextMin(table[i], used );
         }
         Integer[] result = new Integer[vertices.length];
         for (int i = 0; i < vertices.length; i++) {
             result[i] = table[vertices.length - 1][i];
         }
         return result;
     }
     
     int nextMin(Integer[] integers, List used) {
        Integer min = null;
        Integer minIndex = null;
        for(int i = 0; i < integers.length; i++) {
            if(!used.contains(i) && integers[i] != null) {
                if(min == null || min > integers[i]) {
                    min = integers[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    int[] getnextvertices(int current) {
         
         int size = 0;
         for(int i = 0;i<vertices.length;i++) {
             if(edges[current][i]!=null) {
                 size++;
             }
         }
         int[] result = new int[size];
         int index=0;
         for(int i = 0;i<vertices.length;i++) {
             if(edges[current][i]!=null) {
                 result[index]=i;
                 index++;
             }
         }
         return result;
     }
}
