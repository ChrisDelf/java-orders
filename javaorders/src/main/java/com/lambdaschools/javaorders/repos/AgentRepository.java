package com.lambdaschools.javaorders.repos;

import com.lambdaschools.javaorders.model.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long>// takes Agent Object and log type as class
{

}
