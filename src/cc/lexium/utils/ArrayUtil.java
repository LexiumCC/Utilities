package cc.lexium.utils;

public class ArrayUtil {

    public static Object find(Object[] list, Object target)
    {
        for (Object o : list)
        {
            if (o == target)
            {
                return o;
            }
        }
        return null;
    }

    public static int position(Object[] list, Object target)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == target)
            {
                return i;
            }
        }

        throw new Error();
    }

    
    
    public static void replace(Object[] list, Object target, Object substitute)
    {
        list[position(list, target)] = substitute;
    }

    public static boolean exists(Object[] list, Object object)
    {
        return find(list, object) == null;
    }

     public static Object getRandomItem(Object[] list)
     {
        Random random = new Random();
        return list[random.nextInt(list.length)];
     }
    
}
