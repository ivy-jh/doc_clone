import ch.ivyteam.ivy.workflow.query.TaskQuery;
import ch.ivyteam.ivy.workflow.ITask;

// create a new query
TaskQuery query = TaskQuery.create()
  .aggregate().avgCustomDecimalField1()
  .where().customVarCharField1().isEqual("ivy")
  .groupBy().state()
  .orderBy().customVarCharField2().descending();
// retrieve query results
List<ITask> tasks = ivy.wf.getTaskQueryExecutor().getResults(query);
