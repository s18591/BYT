using System;

namespace PoolPattern
{
    class Program
    {
        static void Main(string[] args)
        {
            ObjectPool objectPool = new ObjectPool();
            PooledObject pooledObject = objectPool.GetPooledObject();
            Console.WriteLine("After getPooledObject: free.size=" + objectPool.free.Count + " used.size=" + objectPool.used.Count);
            objectPool.relesePooledObject(pooledObject);
            Console.WriteLine("After releasePooledObject: free.size=" + objectPool.free.Count + " used.size=" + objectPool.used.Count);
        }
    }
}
