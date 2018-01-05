FROM java:8

WORKDIR /

# Copy the current directory contents into the container at /app
ADD target/server-1.0.jar /
ADD Video /root/Video

# Install any needed packages specified in requirements.txt
# Make port 80 available to the world outside this container
EXPOSE 8080
RUN apt-get update -y && apt-get install -y software-properties-common && apt-get install -y python-software-properties && add-apt-repository ppa:jonathonf/ffmpeg-3 && apt update -y &&  apt upgrade -y
CMD ["java","-jar", "server-1.0.jar"]
