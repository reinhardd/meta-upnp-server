# meta-upnp-server

this repo contains metadata to build a small upnp home server 

upnp-server-image provides the gerbera upnp server build around a systemd based runtime.


## Usage on yocto compatible systems


### yocto compatibility

Have a look at 

https://docs.yoctoproject.org/ref-manual/system-requirements.html?highlight=fedora#supported-linux-distributions

and check against the assignement `SANITY_TESTED_DISTROS ?= ...` in file `layers/poky/meta-poky/conf/distro/poky.conf`

If your system is not compatible try the toolbox approach described below. You may also use docker instead.

### install packages

Install missing dependencies. 

https://docs.yoctoproject.org/ref-manual/system-requirements.html?highlight=requirements#required-packages-for-the-build-host should tell you what is needed. 

Unfortunately this is not enough. Some packages need soome perl tools, mostly when configuring packages, that could be missing on your host. 
Compilations stops with i.e. `Can't locate XXX.pm in @INC (you may need to install the XXX module)`. 
Search for and install them using the systems package manager.


### Enter the bitbake shell

1. source loadenv -c < template >  
    templates are directories within `layers/meta-local/conf/templates/`  
    rockpi-4b is the only available target template for now  
    to add a template for your own target-machine   
    create a directory in  
    and setup local.conf.sample, bblayers.conf.sample and optionally conf-notes.txt  
2. use bitbake and companions


## Provide a toolbox environment

toolbox is not limited to fedora images. 

Have a look at (**caution: versioned link**) 

https://github.com/containers/toolbox/tree/0.0.99.5/images 

for what is available and select one of them that is listed in the assignment
`SANITY_TESTED_DISTROS ?= "..." `in file`layers/poky/meta-poky/conf/distro/poky.conf` 

### create a toolbox environment

For general usage information see https://github.com/containers/toolbox .

1. create a container  
   choose a meaningfull container name for it
   
2. install needed packages  
   `https://docs.yoctoproject.org/ref-manual/system-requirements.html?highlight=fedora#required-packages-for-the-build-host`  
   
   **WARNING: when using a fedora image be carefull when installing packages, this may trigger unwanted interactions with your host system.**
   
3. assign that container name to TOOLBOX_CONTAINER in setup.conf  
   uncomment that entry

### enter that environment

simply use `./enter-toolbox`

If your toolbox setup is valid the shell prompt should change to `[<user>@toolbox meta-upnp-server]$` 
or something similar and you could go on like described above

