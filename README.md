# License
All metadata is MIT licensed unless otherwise stated. Source code of packages
tarballed and released in the github for individual recipes is under the LICENSE
stated in the associated recipe (.bb file) unless otherwise stated.
License information for any other recipes is either explicitly stated or defaults to GPL version 2.

The use of this Intel Atom E3900 BSP with Linux Kernel is licensed under [SOFTWARE LIMITED LICENSE AGREEMENT](https://github.com/intel/iotg-yocto-bsp-public/blob/e3900/master/Intel%20Software%20License_15Oct15.pdf)

# About Intel Atom E3900 Yocto BSP
This Intel Atom E3900 BSP contains the following essential components for building a custom embedded Linux image.
- One-Click setup script for setting up build environment from scratch
- meta-intel-leafhill layer for Linux kernel configurations
- meta-intel-middleware layer for user space packages and configurations
- template of local.conf for building core-image-sato-sdk and core-image-sato image

Minimum host system configuration for Yocto BSP build:
- Intel Core i7 multi-core (4 cores)
- The Linux OS of choice for Yocto Project build is Ubuntu 16.04 LTS.
- 4GB RAM and at least 500GB disk space
- High speed network connectivity

IMPORTANT: To enable Yocto BSP build, you will need to setup and enable SSH keys on your host machine.
See the [Setting up Guide](https://github.com/intel/iotg-yocto-bsp-public/wiki/SSH-Setup-Guide-for-New-Users) for more details.

## Getting Started with Yocto BSP for Intel Atom E3900 SoC
- Make sure you have setup SSH connection to GitHub for recipe to pull Linux kernel.
- Execute the setup.sh script to check your host machine settings, download Poky and other meta layers from Yocto Project and prepare your environment for build.

**NOTE: Do not interrupt the setup.sh execution especially during local repository initialization**

#### Default configuration set for core-image-sato image in this BSP:
- meta-intel-middleware contains i915 graphics driver. However, they are dependent on gstreamer plugins.
  <br> These plugins require license flags set to "commercial" in order to be included in the build.
  <br> You will find LICENSE_FLAGS_WHITELIST = "commercial" already set by the template in the local.conf for your build.

- To enable full graphics video and display in the image, we have included a packagegroup tailored to showcase the graphics capability on this platform.
You will find the packagegroup-graphics-essential in meta-intel-middleware.
This packagegroup is set to build into core-image-sato-sdk by default in this BSP.

Image name can be core-image-sato or core-image-sato-sdk.

At the end of a successful build, you should have a live image that you can boot from a USB flash drive.
You can deploy the hddimg image to a USB or SATA device.

### Your First Build
If this is your first build, just run the setup.sh script from your iotg-yocto-bsp-public/ directory:
```
   $ ./setup.sh
```

- The setup.sh script will prompt you with a menu for choice of build.
   By default, the core-image-sato-sdk will be build.
   Otherwise, you may key in the numerical selection for building core-image-sato or Linux kernel for the bzImage
   or setting up for a custom build.

- Setup.sh will perform the following tasks prior to building Yocto BSP image:
   a. Host Machine build environment check
	- check for Linux distro on host machine
	- check for required software dependencies (this is only performed for Linux Ubuntu 14.04)
	- test python, network, gitconfig and git proxy
	- Prepare sources
	- download Linux kernel v4.19.152 from Intel Linux Kernel from github.
	- combolayer downloads Poky Warrior v2.7.4 and other meta layers based on setup/combolayer.conf
	- setup bblayers for bitbake build
	- setup local.conf for bitbake build
	- prepare environment for bitbake build
	- start the bitbake image build automatically based on selection

- This process will create a build folder named "yocto_build" at the same level directory as your bsp-apollolake-i.
  Yocto bitbake will be running at this directory <your path>/yocto_build/build/.
  For setup.sh to run completely, this process may take serveral hours or more depending on the performance
  of your build machine. When the build process is completed, you may browse for the image from the path:

   Your bootable image location is:-
   <your_path>/yocto_build/build/tmp/deploy/images/intel-corei7-64/
	- HDDIMG image file name: core-image-sato-sdk-intel-corei7-64-<build-date-time>.hddimg
	- WIC image file name: core-image-sato-sdk-intel-corei7-64-<build-date-time>.rootfs.wic
### For Subsequent Build
If you need to modify the recipes or configurations, make your customization in the yocto_build folder after running the ./setup script on your host machine.

- When you are ready to rebuild, go to yocto_build folder to run:
```
	$ cd <path to directory>/yocto_build

	# When you source in your yocto_build directory, you will be automatically be routed to the build/ directory
	$ source oe-init-build-env

	# For core-image-sato
	$ bitbake core-image-sato

	# For core-image-sato-sdk
	$ bitbake core-image-sato-sdk

	# For linux-kernel bzImage only
	$ bitbake linux-intel
```

### Kernel Source
Intel Atom E3900 BSP utilize linux-intel kernel from Intel Github which is hosted in [Intel Github repositories](https://github.com/intel/linux-intel-lts). The branch for Intel Atom E3900 BSP kernel is 4.19/base.

### Features supported
To view the full list of supported features, please refer BSP release notes in [Technical Libary for Intel Atom E3900 Series](https://www.intel.com/content/www/us/en/embedded/products/apollo-lake/technical-library.html)

### Known Issues
To view full list of known issues related to Linux driver, please refer BSP release notes in [Technical Libary for Intel Atom E3900 Series](https://www.intel.com/content/www/us/en/embedded/products/apollo-lake/technical-library.html)
