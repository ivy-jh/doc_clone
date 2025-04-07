TaskQuery query = TaskQuery.create()
  .where().currentUserCanWorkOn()
  .orderBy().priority();
List<ITask> userWorkTasks = ivy.wf.getTaskQueryExecutor().getResults(query);
