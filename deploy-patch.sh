FRAMEWORK_HOME=/Users/farasath/IS/carbon-identity-framework
COMPONENT_HOME=$FRAMEWORK_HOME/components/authentication-framework/org.wso2.carbon.identity.application.authentication.endpoint.util
cd $COMPONENT_HOME
mvn clean install

IDENTITY_APPS_HOME=/Users/farasath/IS/identity-apps
AUTH_ENDPOINT_HOME=$IDENTITY_APPS_HOME/apps/authentication-portal
cd $AUTH_ENDPOINT_HOME
mvn clean install


IS_HOME=/Users/farasath/IS/product-is
TEST_PACK=$IS_HOME/modules/distribution/target/wso2is-5.11.0-m10-SNAPSHOT
#
PATCH_DIRECTORY=$TEST_PACK/lib/runtimes/cxf3
rm -rf $PATCH_DIRECTORY/org.wso2.carbon.identity.application.authentication.endpoint.util-*SNAPSHOT.jar
## Copy the patched jar
cp $COMPONENT_HOME/target/org.wso2.carbon.identity.application.authentication.endpoint.util-*SNAPSHOT.jar $PATCH_DIRECTORY
#

WEB_APPS_DIR=$TEST_PACK/repository/deployment/server/webapps
rm -rf $WEB_APPS_DIR/authenticationendpoint
mkdir $WEB_APPS_DIR/authenticationendpoint
cd $WEB_APPS_DIR/authenticationendpoint
unzip $AUTH_ENDPOINT_HOME/target/authenticationendpoint.war
