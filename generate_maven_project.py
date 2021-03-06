#mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
#mercury501
import os
from random import randint
import subprocess
import time

pom_mod1 = '''    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-assembly-plugin</artifactId>
        <version>3.3.0</version>
        <configuration>
          <archive>
            <manifest>
              <mainClass>'''


pom_mod2 = '''.App</mainClass>
            </manifest>
          </archive>
          <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
            <descriptorRef>src</descriptorRef>
          </descriptorRefs>
        </configuration>
        <executions>
          <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
              <goal>single</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
</project>
'''

pom_mod_lambdaMod = '''     <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>'''

default_GID = "oop21"
default_AID = "test" + str(randint(0,25))
GID = ""
AID = ""
command = ""

cd = input("Insert subfolder, leave blank for default, current folder: ")



folder = os.path.join(os.path.dirname(os.path.realpath(__file__)), cd)

command += "cd " + folder + " & " + "mvn archetype:generate -DgroupId="

GID = input("Input goupID, leave blank for default(" + default_GID + "): ")

if GID == "":
	GID = default_GID



AID = input("Input artifactID, leave blank for default(" + default_AID + "): ")

if AID == "":
	AID = default_AID

extended_GID = GID + '.' + AID
command += extended_GID + " -DartifactId="
command += AID + " -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false"

print("Generating project with groupID: " + GID +", artifactID: " + AID)
print(command)

os.system(command)
pom_mod = pom_mod1 + GID + "." + AID + pom_mod2

old_pom_path = os.path.join(folder, AID, "pom.xml")
new_pom_path = os.path.join(folder, AID, "npom.xml")

print("Adding dependencies to pom.xml...")

with open(old_pom_path) as f1:
    lines = f1.readlines()
    f1.close()

with open(new_pom_path, 'w') as f2:
	f2.writelines(lines[0:16])
	f2.writelines(pom_mod_lambdaMod)
	f2.writelines(lines[18:73])
	f2.writelines(pom_mod)

	f2.close()

os.remove(old_pom_path)
os.rename(new_pom_path, old_pom_path)

#subprocess.run(["powershell", "-Command", rm_old_pom])
#subprocess.run(["powershell", "-Command", rename_pom])

print("DONE!")
#time.sleep(2)