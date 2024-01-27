 
SUMMARY = "A small upnp-server image"

CORE_PACKAGES = " \ 
    networkmanager \ 
    networkmanager-nmcli \
    networkmanager-wifi \
    cockpit \
    cockpit-desktop \
    cockpit-networkmanager \
    cockpit-dashboard \
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

IMAGE_INSTALL = " \ 
packagegroup-core-boot \ 
${CORE_IMAGE_EXTRA_INSTALL} \
${CORE_PACKAGES} \
${UPNP_PACKAGES} \
"

IMAGE_LINGUAS = "de-de en-us"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

