package com.IceCreamQAQ.YuQ.entity;

import com.sobte.cqp.jcq.entity.Anonymous;
import lombok.Getter;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Message extends Exception{

    private Integer id;

    private Long qq;
    private Long group;
    private Anonymous noName;

    private String msg;
    private String[] texts;

    private Message(){

    }

    /***
     * 不建议直接使用本方法，在之后版本会根据内容随时进行调整。
     * @param id 消息id
     * @param qq 发送的QQ号
     * @param group 群号
     * @param noName 匿名消息
     * @param texts 内容
     * @return 构建好的message对象。
     */
    @Deprecated
    public static Message buildMessage(Integer id,Long qq,Long group,Anonymous noName,String[] texts,String msg){
        val message=new Message();
        message.id=id;
        message.qq=qq;
        message.group=group;
        message.noName=noName;
        message.texts=texts;
        message.msg=msg;
        return message;
    }

    public static class Builder{

        private Message message;
        private StringBuilder msg;

        public Builder(){
            message=new Message();
            msg=new StringBuilder();
        }

        public Builder(String text){
            this();
            msg.append(text);
        }

        public Builder setQQ(Long qq){
            message.qq=qq;
            return this;
        }

        public Builder setGroup(Long group){
            message.group=group;
            return this;
        }

        public Builder append(String text){
            msg.append(text);
            return this;
        }

        public Message build(){
            message.msg=msg.toString();
            return message;
        }
    }
}