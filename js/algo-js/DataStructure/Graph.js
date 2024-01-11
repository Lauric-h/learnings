export default class Graph {
    constructor() {
        this.adjacencyList = {}
    }

    addVertex(vertex) {
        if (!this.adjacencyList[vertex]) {
            this.adjacencyList[vertex] = {}
        }
    }

    addEdge(source, destination) {
        if (!this.adjacencyList[source.vertex]) {
            this.addVertex(source.vertex)
        }
        if (!this.adjacencyList[destination.vertex]) {
            this.addVertex(destination.vertex)
        }

        this.adjacencyList[source.vertex][destination.vertex] = destination.cost
        this.adjacencyList[destination.vertex][source.vertex] = source.cost

        return this
    }

    removeEdge(source, destination) {
        this.adjacencyList[source] = this.adjacencyList[source].filter(vertex => vertex !== destination)
        this.adjacencyList[destination] = this.adjacencyList[destination].filter(vertex => vertex !== source)
    }

    removeVertex(vertex) {
        while(this.adjacencyList[vertex]) {
            const adjacentVertex = this.adjacencyList[vertex].pop()
            this.removeEdge(vertex, adjacentVertex)
        }
        delete this.adjacencyList[vertex]
    }

    getRandomCost(max) {
        return Math.floor(Math.random() * max)
    }

}
