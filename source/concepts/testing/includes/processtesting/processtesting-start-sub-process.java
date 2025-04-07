SubProcessCallResult result = bpmClient.start()
        .subProcess(REGISTER_AGENT)
        .execute("James Bond", 7) // callable sub process input arguments
        .subResult();

assertThat(result.param("agent", String.class)).isEqualTo("James Bond");
assertThat(result.param("doubleZeroNumber", Number.class)).isEqualTo(7);
