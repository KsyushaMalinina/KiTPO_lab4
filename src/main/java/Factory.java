import Builder.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import Builder.BuilderGPS;
import Builder.BuilderInteger;

public class Factory {
    public static ArrayList<String> getTypeNameList() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("  ","Integer","GPS"));
        return list;
    }

    public static Builder getBuilderByName(String name) throws Exception
    {
        if (name.equals(BuilderGPS.typename))
        {
            return new BuilderGPS();
        }
        else if (name.equals(BuilderInteger.typename))
        {
            return new BuilderInteger();
        }
        else
        {
            return null;
        }
    }

}
