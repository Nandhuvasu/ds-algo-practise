### INTRODUCTION

https://www.algoexpert.io/data-structures

Very important for coding interviews

Complicated under the hood

Its a key-value store

Given a key, you can access the value

You can't do the opposite

Insertions, Deletion, search or access run on constant time (in avg) O(1)

Almost similar to an array.

Built on top of array

Hash function - transform key to index

Modulo op used to identify position. Number % length of underlying array. It would yield result 0 < result < length of array.

Each index maps to linked list of potential values. If two indices gets same index number from hashing function. (Collisions!)

Each node of this linked list need to point to its key.

Worst case: all keys gets same  number from hash func

So all ops will be O(n) in the worst case.

Fancy hash functions available that minimise collisions. So, forget abt worst case of  O(N).

Constant time look-ups - go for hash maps

what if underlying array length is limited? => Resizing

Implement hash table that basically resizes itself

Like dynamic array - new hashing func, coz new length, new indices.

Resizing is gonna happen very infrequently. so consider constant time for all ops.

O(N) space.

Keys can be of other data structures too. (check limitations in Java)




