 
SUMMARY = "A small upnp-server image"

IMAGE_FEATURES += "package-management hwcodecs ssh-server-openssh"

CORE_PACKAGES = " \ 
    kernel-modules \
    networkmanager \ 
    networkmanager-nmcli \
    networkmanager-wifi \
    cockpit \
    cockpit-ws \
    cockpit-desktop \
    cockpit-networkmanager \
    cockpit-dashboard \
    cockpit-packagekit \
    cockpit-systemd \
    cockpit-shell \
    firewalld \ 
    firewalld-applet \ 
    firewalld-log-rotate \ 
    firewalld-config \ 
    firewalld-offline-cmd \ 
    dbus-broker \
"

UPNP_PACKAGES = " \
    gerbera \
"

DEVTOOLS = " \
bmap-tools \
lsof \
psmisc \
strace \
nano \
"

IMAGE_INSTALL = " \ 
packagegroup-core-boot \ 
${CORE_IMAGE_EXTRA_INSTALL} \
${CORE_PACKAGES} \
${UPNP_PACKAGES} \
${DEVTOOLS} \
"

IMAGE_LINGUAS = "de-de en-us"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

