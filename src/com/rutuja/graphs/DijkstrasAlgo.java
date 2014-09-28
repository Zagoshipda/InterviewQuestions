package com.rutuja.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import com.rutuja.graphs.AdjacencyList.Edge;

public class DijkstrasAlgo {
	
	class Pair implements Comparable<Pair>{
		private int u;
		private int weight;
		public Pair(int u, int weight) {
			super();
			this.u = u;
			this.weight = weight;
		}
		@Override
		public int compareTo(Pair other) {
			if(this.weight>other.weight)
			return 1;
			else return -1;
		}
		
	}
	
	public int findDistance(int src, int des, AdjacencyList al ){
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int[] dist = new int[al.getTotalVertices()];
		int[] parent = new int[al.getTotalVertices()];
		Arrays.fill(parent, -1);
		Arrays.fill(dist,Integer.MAX_VALUE/2);
		dist[src] = 0;
		pq.add(new Pair(src,dist[src]));
		while(!pq.isEmpty()){
			int u = pq.poll().u;
			if(u == des) break;
			for(Edge e : al.getEdges(u)){
				if(dist[u]+ e.getWeight() < dist[e.getV()]){
					dist[e.getV()] = dist[u]+e.getWeight();
					pq.add(new Pair(e.getV(), dist[e.getV()]));
					parent[e.getV()] = u;
				}
			}
		}
		int u = des;
		StringBuilder res = new StringBuilder();
		while(u!=-1){
			res.append(u);
			res.append(">--");
			u = parent[u];
		}
		System.out.println(res.reverse());
		return dist[des];
		
		
		
	}

}
