def call(){
  sh """
# Set variables
NEXUS_URL="http://13.201.16.66:8081"
REPOSITORY="ai-leads-release"
GROUP_ID="in.javahome"
ARTIFACT_ID="ai-leads"
VERSION="1.1"
USERNAME="admin"
PASSWORD="admin"

# Retrieve artifact metadata
METADATA=$(curl -s -u "${USERNAME}:${PASSWORD}" "${NEXUS_URL}/service/rest/v1/search/assets?repository=${REPOSITORY}&group=${GROUP_ID}&name=${ARTIFACT_ID}&version=${VERSION}")
echo $METADATA
# Extract the download URL from the metadata
DOWNLOAD_URL=$(echo "${METADATA}" | jq -r '.items[0].downloadUrl')

# Download the artifact
curl -u "${USERNAME}:${PASSWORD}" -O "${DOWNLOAD_URL}"

  """
}
