package com.microsoft.applicationinsights.management.rest;

import com.microsoft.applicationinsights.management.rest.client.Client;
import com.microsoft.applicationinsights.management.rest.client.HttpMethod;
import com.microsoft.applicationinsights.management.rest.operations.*;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Matchers;

import java.io.IOException;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by yonisha on 4/19/2015.
 */
public class ApplicationInsightsManagementClientTests {

    private final String DEFAULT_RESOURCE_GROUP = "resource_group";
    private final String DEFAULT_RESOURCE_NAME = "resource_name";
    private final String DEFAULT_SUBSCRIPTION_ID = "subscription_id";
    private Client restClient = mock(Client.class);

    @Test
    public void testGetSubscriptionsOperation() throws IOException, AzureCmdException {
        GetSubscriptionsOperation getSubscriptionsOperation = new GetSubscriptionsOperation();
        getSubscriptionsOperation.execute(restClient);

        verify(restClient).executeGet(Matchers.anyString(), Matchers.anyString());
    }

    @Test
    public void testGetResourcesOperation() throws IOException, AzureCmdException {

        GetResourcesOperation getResourcesOperation = new GetResourcesOperation(DEFAULT_SUBSCRIPTION_ID);
        getResourcesOperation.execute(restClient);

        verify(restClient).executeGet(Matchers.anyString(), Matchers.anyString());
    }

    @Test
    public void testCreateResource() throws IOException, AzureCmdException {
        CreateResourceOperation createResourceOperation =
                new CreateResourceOperation(DEFAULT_SUBSCRIPTION_ID, DEFAULT_RESOURCE_GROUP, DEFAULT_RESOURCE_NAME);
        createResourceOperation.execute(this.restClient);

        verify(restClient).executePut(Matchers.anyString(), Matchers.anyString(), Matchers.anyString());
    }

//    @Test
//    public void testDeleteResource() throws IOException, AzureCmdException {
//        DeleteResourceOperation deleteResourceOperation =
//                new DeleteResourceOperation(DEFAULT_SUBSCRIPTION_ID, DEFAULT_RESOURCE_GROUP, DEFAULT_RESOURCE_NAME);
//        deleteResourceOperation.execute(this.restClient);
//
//        verify(restClient).execute(Matchers.anyString(), eq(HttpMethod.DELETE), Matchers.anyString());
//    }

    @Test
    @Ignore
    public void testIfAccessTokenExpiredItIsRenewed() {

    }
}
