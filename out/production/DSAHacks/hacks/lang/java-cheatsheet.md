**Data structure &amp; Collections in Java**

Jargons: i = index | e = element | k = key | v = value

**ARRAY:** import java.util. **ArrayList** ;

| add(e)<br/>set(i, e)<br/>get(i) | contains(e) | remove(i) | size()<br/>isEmpty() |
|-------------------------| --- | --- | --- |

**SET:** import java.util. **HashSet** ;

| add(e) | contains(e) | remove(e) | size()<br/>isEmpty() |
| --- | --- | --- | --- |

**MAP:** import java.util. **HashMap** ;

| put(k,v)<br/>get(k) | containsKey(k)<br/>containsValue(v) | remove(k) | size()<br/>isEmpty() |
| --- | --- | --- | --- |

**MIN HEAP:** import java.util. **PriorityQueue** ;

| add(e)<br/>offer(e) | contains(e)<br/>peek(e) | remove(e)<br/>poll(e) | size()<br/>isEmpty() |
| --- | --- | --- | --- |

**STACK:** import java.util. **Stack** ;

| push(e)add(e)add(i, e)offer(e) | contains(e)search(e)peek(e) | remove(e)pop(e) | size()empty()isEmpty() |
| --- | --- | --- | --- |

| **Method** | **Modifier and Type** | **Method and Description** |
| --- | --- | --- |
| add | boolean | Inserts the specified element into the collection if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available. |
| offer | boolean | Inserts the specified element into the collection if it is possible to do so immediately without violating capacity restrictions. |
| peek | [e](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html) | Retrieves, but does not remove, the head of this queue, or returns null if the collection is empty. |
| poll | [e](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html) | Retrieves and removes the head of the collection, or returns null if the collection is empty. |
| remove | e | Retrieves and removes the head of the collection. |