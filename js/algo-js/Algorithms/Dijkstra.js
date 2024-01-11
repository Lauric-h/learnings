import PriorityQueue from "../DataStructure/PriorityQueue.js";

export default function Dijkstra(graph, start, target) {
    const queue = new PriorityQueue()
    const distances = {}
    const previous = {}

    let path = []
    let smallest, el, dist

    for (const vertex in graph.adjacencyList) {
        if (vertex === start) {
            distances[vertex] = 0
            el = {
                v: vertex,
                distance: 0
            }
            queue.enqueue(el)
        } else {
            distances[vertex] = Infinity
        }
        previous[vertex] = null
    }

    while (!queue.isEmpty()) {
        smallest = queue.dequeue().v
        if (smallest === target) {
            while(previous[smallest]) {
                path.push(smallest)
                smallest = previous[smallest]
                dist = distances[target]
            }
            break
        }
        if (smallest || distances[smallest] !== Infinity) {
            for (let neighbor in graph.adjacencyList[smallest]) {
                let nextNode = {
                    node: neighbor,
                    cost: graph.adjacencyList[smallest][neighbor]
                }
                let candidate = distances[smallest] + nextNode.cost
                let neighborValue = nextNode.node
                if(candidate < distances[neighborValue]) {
                    distances[neighborValue] = candidate
                    previous[neighborValue] = smallest
                    el = {
                        v: neighborValue,
                        distance: candidate
                    }
                    queue.enqueue(el)
                }
            }
        }
    }
    return path.concat(smallest).reverse()
}
