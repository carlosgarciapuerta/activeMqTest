package es.kgp.activeMQTest.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kgp on 11/01/2014.
 */
public class MQMessage implements Serializable{

    private String text;
    private Date sendTime;

    public MQMessage(String text, Date sendTime) {
        this.text = text;
        this.sendTime = sendTime;
    }

    public String getText() {
        return text;
    }

    public Date getSendTime() {
        return sendTime;
    }

    @Override
    public String toString() {
        return "MQMessage{" +
                "text='" + text + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MQMessage message = (MQMessage) o;

        if (sendTime != null ? !sendTime.equals(message.sendTime) : message.sendTime != null) return false;
        if (text != null ? !text.equals(message.text) : message.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        return result;
    }
}
