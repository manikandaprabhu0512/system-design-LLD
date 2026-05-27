package Patterns.Adapater_Pattern;

/* 
    Adapter converts the interfaces of a class into another interface that client expects. 
    Adapter llets classes work together that couldn't, because of incompatible interface
*/

interface IReports {
    String getJSONData(String data);
}

class XMLProvider {
    String getXMLData(String data) {
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id = data.substring(sep+1);

        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>" + id + "</id>"
                + "</user>";
    }
}

class XMLProviderAdapter implements IReports {
    private XMLProvider provider;
    public XMLProviderAdapter(XMLProvider provider) {
        this.provider = provider;
    }

    @Override
    public String getJSONData(String data) {
        String xml = provider.getXMLData(data);

        int startName = xml.indexOf("<name>") + 6;
        int endName   = xml.indexOf("</name>");
        String name   = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId   = xml.indexOf("</id>");
        String id    = xml.substring(startId, endId);

        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";
    }
}

class Client {
    public void getReport(IReports report, String data) {
        System.out.println("Processed JSON: " + report.getJSONData(data));
    }
}

public class AdapaterPattern {
    public static void main(String[] args) {
        XMLProvider provider = new XMLProvider();

        IReports adapaters = new XMLProviderAdapter(provider);

        String rawData = "Manikanda:09";

        Client client = new Client();

        client.getReport(adapaters, rawData);
    }
}
