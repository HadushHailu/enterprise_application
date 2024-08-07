package bank.service;

import bank.dao.TraceRecordRepository;
import bank.domain.TraceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class CustomEventListener {
    @Autowired
    TraceRecordRepository traceRecordRepository;

    @Async
    @EventListener
    public void onEvent(CustomerEvent event) {
        System.out.println("received event :" + event.getMessage());;
    }

    @Async
    @EventListener
    public void onEvent2(TraceRecord event){
        traceRecordRepository.save(event);
    }
}
