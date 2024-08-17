DESCRIPTION = "Console image for Yuzuki-Lizard V851s"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "
IMAGE_LINGUAS = "pl-pl"

inherit core-image

SYSTEM_TOOLS_INSTALL = " \
    i2c-tools \
    memtester \
    sysbench \
    tzdata \
    devmem2 \
    minicom \
"

KERNEL_EXTRA_INSTALL = " \
    kernel-devicetree \
    kernel-modules \
 "

UTILITIES_INSTALL = " \
    coreutils \
    gdbserver \
    mtd-utils \
    ldd \
    libstdc++ \
    libstdc++-dev \
    openssh-sftp \
    resize-rootfs \
    ppp \
    parted \
    e2fsprogs \
    e2fsprogs-resize2fs \
"

WIFI_SUPPORT = " \
    wpa-supplicant \
"

IMAGE_INSTALL += " \
  ${SYSTEM_TOOLS_INSTALL} \
  ${KERNEL_EXTRA_INSTALL} \
  ${UTILITIES_INSTALL} \
"
