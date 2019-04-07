package People;

import Sorting.ISorted;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
public final class Inject {
    private final static Logger log = Logger.getLogger(Library.class.getName());

    /**
     * Dynamic add sort
     * @param obj
     */
    public static void initSort(Object obj)
    {
        try
        {
            FileReader reader = new FileReader("properties.txt");
            Class c = obj.getClass();
            char[] buf=new char [100];
            reader.read(buf);
            boolean ok=false;
            String val="";
            String name="";
            for(int i=0;i<buf.length;i++)
            {
                if(buf[i]=='=') {
                    ok=true;
                }
                else
                {
                    if(buf[i]==' '|| buf[i]=='\0')
                    {
                        ok=false;
                        for(Field f : c.getDeclaredFields())
                        {
                            if(f.getType().getTypeName().equals(name))
                            {
                                if (f.isAnnotationPresent(Autoinjectble.class)) {
                                    Class c1 = Class.forName(val);
                                    ISorted ob = (ISorted) c1.newInstance();
                                    f.setAccessible(true);
                                    f.set(obj, ob);
                                }
                            }
                        }
                        if(buf[i]=='\0')
                        {
                            break;
                        }
                    }
                    else
                    {
                        if(ok)
                        {
                            val+=buf[i];
                        }
                        else
                        {
                            name+=buf[i];
                        }
                    }
                }
            }
            reader.close();
        }
        catch(Exception ex)
        {
            log.log( Level.SEVERE, ex.toString(), ex );
        }
    }
}
