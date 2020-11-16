using System;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using System.Text;

namespace PoolPattern
{
    class ObjectPool
    {
      public List<PooledObject> free = new List<PooledObject>();
       public  List<PooledObject> used = new List<PooledObject>();
 

        public PooledObject GetPooledObject()
        {
            PooledObject pooledObject1 = new PooledObject("object");
            free.Add(pooledObject1);
            if (free == null)
            {
                PooledObject pooledObject = new PooledObject("new");
                used.Add(pooledObject);
                return pooledObject;
            }
            else
            {
                PooledObject pooledObject = free[0];
                used.Add(pooledObject);
                free.Remove(pooledObject);
                return pooledObject;
            }
        }
       public void relesePooledObject(PooledObject pooledObject)
        {
            used.Remove(pooledObject);
            free.Add(pooledObject);
        }
    }
}
