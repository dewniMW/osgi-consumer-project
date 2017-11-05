package com.example.osgiconsumer.package01.internal;

import com.example.osgiproducer.package01.Producer;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * Created by dewni on 10/4/17.
 */
@Component(name = "com.example.osgiconsumer.package01.ConsumerComponent",
        immediate = true)
public class ConsumerComponent {
    Producer producer = null;

    @Activate
    protected void activate(BundleContext bundleContext) {
        producer.produce("producer component");
    }

    @Reference(name = "producerService", service = Producer.class,
                cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.DYNAMIC, unbind = "unbindService")
    protected void registerService(Producer producer){
        this.producer = producer;
    }

    protected void unbindService(Producer producer){

    }
}

