package max.iv.task_management_system.exceptions;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class TaskAlreadyExistsException extends RuntimeException{

    public TaskAlreadyExistsException(String m){
        super(m);
        log.error(m);
    }

}
