package mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Subscriber implements MqttCallback{

	public Subscriber(){
		 String topic        = "home/room1";
		    int qos             = 2;
		    String broker       = "tcp://localhost:1883";
		    String clientId     = "subscriber1";
		    MemoryPersistence persistence = new MemoryPersistence();

		    try {
		        MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
		        MqttConnectOptions connOpts = new MqttConnectOptions();
		        connOpts.setCleanSession(true);
		        System.out.println("Connecting to broker: "+broker);
		        sampleClient.setCallback(this);
		        sampleClient.connect(connOpts);
		        System.out.println("Connected");
		        sampleClient.subscribe(topic);
		        System.out.println("subscribed to " + topic);

		        
		    } catch(MqttException me) {
		        System.out.println("reason "+me.getReasonCode());
		        System.out.println("msg "+me.getMessage());
		        System.out.println("loc "+me.getLocalizedMessage());
		        System.out.println("cause "+me.getCause());
		        System.out.println("excep "+me);
		        me.printStackTrace();
		    }
	}
	
public static void main(String[] args) {
	Subscriber mySubscriber = new Subscriber();
}

public void connectionLost(Throwable cause) {
	// TODO Auto-generated method stub
	
}

public void messageArrived(String topic, MqttMessage message) throws Exception {
	
	System.out.println("Subscriber1 received message :" + message.toString());
	Thread.sleep(3000);
	
}

public void deliveryComplete(IMqttDeliveryToken token) {
	// TODO Auto-generated method stub
	
}

}