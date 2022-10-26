package com.zww.music_mvvm.data.bean;

import java.util.List;

public class HomeDiscoverBean {

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private String cursor;
        private List<BlocksBean> blocks;
        private boolean hasMore;
        private Object blockUUIDs;
        private PageConfigBean pageConfig;
        private GuideToastBean guideToast;
        private Object internalTest;
        private List<?> titles;
        private Object blockCodeOrderList;
        private String exposedResource;
        private boolean demote;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<BlocksBean> getBlocks() {
            return blocks;
        }

        public void setBlocks(List<BlocksBean> blocks) {
            this.blocks = blocks;
        }

        public boolean isHasMore() {
            return hasMore;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        public Object getBlockUUIDs() {
            return blockUUIDs;
        }

        public void setBlockUUIDs(Object blockUUIDs) {
            this.blockUUIDs = blockUUIDs;
        }

        public PageConfigBean getPageConfig() {
            return pageConfig;
        }

        public void setPageConfig(PageConfigBean pageConfig) {
            this.pageConfig = pageConfig;
        }

        public GuideToastBean getGuideToast() {
            return guideToast;
        }

        public void setGuideToast(GuideToastBean guideToast) {
            this.guideToast = guideToast;
        }

        public Object getInternalTest() {
            return internalTest;
        }

        public void setInternalTest(Object internalTest) {
            this.internalTest = internalTest;
        }

        public List<?> getTitles() {
            return titles;
        }

        public void setTitles(List<?> titles) {
            this.titles = titles;
        }

        public Object getBlockCodeOrderList() {
            return blockCodeOrderList;
        }

        public void setBlockCodeOrderList(Object blockCodeOrderList) {
            this.blockCodeOrderList = blockCodeOrderList;
        }

        public String getExposedResource() {
            return exposedResource;
        }

        public void setExposedResource(String exposedResource) {
            this.exposedResource = exposedResource;
        }

        public boolean isDemote() {
            return demote;
        }

        public void setDemote(boolean demote) {
            this.demote = demote;
        }

        public static class PageConfigBean {
            private String refreshToast;
            private String nodataToast;
            private int refreshInterval;
            private Object title;
            private boolean fullscreen;
            private List<String> abtest;
            private List<String> songLabelMarkPriority;
            private int songLabelMarkLimit;
            private String homepageMode;
            private boolean showModeEntry;
            private String orderInfo;

            public String getRefreshToast() {
                return refreshToast;
            }

            public void setRefreshToast(String refreshToast) {
                this.refreshToast = refreshToast;
            }

            public String getNodataToast() {
                return nodataToast;
            }

            public void setNodataToast(String nodataToast) {
                this.nodataToast = nodataToast;
            }

            public int getRefreshInterval() {
                return refreshInterval;
            }

            public void setRefreshInterval(int refreshInterval) {
                this.refreshInterval = refreshInterval;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public boolean isFullscreen() {
                return fullscreen;
            }

            public void setFullscreen(boolean fullscreen) {
                this.fullscreen = fullscreen;
            }

            public List<String> getAbtest() {
                return abtest;
            }

            public void setAbtest(List<String> abtest) {
                this.abtest = abtest;
            }

            public List<String> getSongLabelMarkPriority() {
                return songLabelMarkPriority;
            }

            public void setSongLabelMarkPriority(List<String> songLabelMarkPriority) {
                this.songLabelMarkPriority = songLabelMarkPriority;
            }

            public int getSongLabelMarkLimit() {
                return songLabelMarkLimit;
            }

            public void setSongLabelMarkLimit(int songLabelMarkLimit) {
                this.songLabelMarkLimit = songLabelMarkLimit;
            }

            public String getHomepageMode() {
                return homepageMode;
            }

            public void setHomepageMode(String homepageMode) {
                this.homepageMode = homepageMode;
            }

            public boolean isShowModeEntry() {
                return showModeEntry;
            }

            public void setShowModeEntry(boolean showModeEntry) {
                this.showModeEntry = showModeEntry;
            }

            public String getOrderInfo() {
                return orderInfo;
            }

            public void setOrderInfo(String orderInfo) {
                this.orderInfo = orderInfo;
            }
        }

        public static class GuideToastBean {
            private boolean hasGuideToast;
            private List<?> toastList;

            public boolean isHasGuideToast() {
                return hasGuideToast;
            }

            public void setHasGuideToast(boolean hasGuideToast) {
                this.hasGuideToast = hasGuideToast;
            }

            public List<?> getToastList() {
                return toastList;
            }

            public void setToastList(List<?> toastList) {
                this.toastList = toastList;
            }
        }

        public static class BlocksBean {
            private String blockCode;
            private String showType;
            private int dislikeShowType;
            private String action;
            private String actionType;
            private UiElementBean uiElement;
            private List<CreativesBean> creatives;
            private boolean canClose;
            private int blockStyle;
            private boolean canFeedback;
            private List<String> resourceIdList;

            public String getBlockCode() {
                return blockCode;
            }

            public void setBlockCode(String blockCode) {
                this.blockCode = blockCode;
            }

            public String getShowType() {
                return showType;
            }

            public void setShowType(String showType) {
                this.showType = showType;
            }

            public int getDislikeShowType() {
                return dislikeShowType;
            }

            public void setDislikeShowType(int dislikeShowType) {
                this.dislikeShowType = dislikeShowType;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public String getActionType() {
                return actionType;
            }

            public void setActionType(String actionType) {
                this.actionType = actionType;
            }

            public UiElementBean getUiElement() {
                return uiElement;
            }

            public void setUiElement(UiElementBean uiElement) {
                this.uiElement = uiElement;
            }

            public List<CreativesBean> getCreatives() {
                return creatives;
            }

            public void setCreatives(List<CreativesBean> creatives) {
                this.creatives = creatives;
            }

            public boolean isCanClose() {
                return canClose;
            }

            public void setCanClose(boolean canClose) {
                this.canClose = canClose;
            }

            public int getBlockStyle() {
                return blockStyle;
            }

            public void setBlockStyle(int blockStyle) {
                this.blockStyle = blockStyle;
            }

            public boolean isCanFeedback() {
                return canFeedback;
            }

            public void setCanFeedback(boolean canFeedback) {
                this.canFeedback = canFeedback;
            }

            public List<String> getResourceIdList() {
                return resourceIdList;
            }

            public void setResourceIdList(List<String> resourceIdList) {
                this.resourceIdList = resourceIdList;
            }

            public static class UiElementBean {
                private SubTitleBean subTitle;
                private ButtonBean button;
                private String rcmdShowType;

                public SubTitleBean getSubTitle() {
                    return subTitle;
                }

                public void setSubTitle(SubTitleBean subTitle) {
                    this.subTitle = subTitle;
                }

                public ButtonBean getButton() {
                    return button;
                }

                public void setButton(ButtonBean button) {
                    this.button = button;
                }

                public String getRcmdShowType() {
                    return rcmdShowType;
                }

                public void setRcmdShowType(String rcmdShowType) {
                    this.rcmdShowType = rcmdShowType;
                }

                public static class SubTitleBean {
                    private String title;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                }

                public static class ButtonBean {
                    private String action;
                    private String actionType;
                    private String text;
                    private Object iconUrl;
                    private Object biData;

                    public String getAction() {
                        return action;
                    }

                    public void setAction(String action) {
                        this.action = action;
                    }

                    public String getActionType() {
                        return actionType;
                    }

                    public void setActionType(String actionType) {
                        this.actionType = actionType;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public Object getIconUrl() {
                        return iconUrl;
                    }

                    public void setIconUrl(Object iconUrl) {
                        this.iconUrl = iconUrl;
                    }

                    public Object getBiData() {
                        return biData;
                    }

                    public void setBiData(Object biData) {
                        this.biData = biData;
                    }
                }
            }

            public static class CreativesBean {
                private String creativeType;
                private String creativeId;
                private String action;
                private String actionType;
                private UiElementBean uiElement;
                private List<ResourcesBean> resources;
                private String alg;
                private String logInfo;
                private int position;

                public String getCreativeType() {
                    return creativeType;
                }

                public void setCreativeType(String creativeType) {
                    this.creativeType = creativeType;
                }

                public String getCreativeId() {
                    return creativeId;
                }

                public void setCreativeId(String creativeId) {
                    this.creativeId = creativeId;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }

                public String getActionType() {
                    return actionType;
                }

                public void setActionType(String actionType) {
                    this.actionType = actionType;
                }

                public UiElementBean getUiElement() {
                    return uiElement;
                }

                public void setUiElement(UiElementBean uiElement) {
                    this.uiElement = uiElement;
                }

                public List<ResourcesBean> getResources() {
                    return resources;
                }

                public void setResources(List<ResourcesBean> resources) {
                    this.resources = resources;
                }

                public String getAlg() {
                    return alg;
                }

                public void setAlg(String alg) {
                    this.alg = alg;
                }

                public String getLogInfo() {
                    return logInfo;
                }

                public void setLogInfo(String logInfo) {
                    this.logInfo = logInfo;
                }

                public int getPosition() {
                    return position;
                }

                public void setPosition(int position) {
                    this.position = position;
                }

                public static class UiElementBean {
                    private MainTitleBean mainTitle;
                    private ImageBean image;
                    private List<String> labelTexts;
                    private String rcmdShowType;

                    public MainTitleBean getMainTitle() {
                        return mainTitle;
                    }

                    public void setMainTitle(MainTitleBean mainTitle) {
                        this.mainTitle = mainTitle;
                    }

                    public ImageBean getImage() {
                        return image;
                    }

                    public void setImage(ImageBean image) {
                        this.image = image;
                    }

                    public List<String> getLabelTexts() {
                        return labelTexts;
                    }

                    public void setLabelTexts(List<String> labelTexts) {
                        this.labelTexts = labelTexts;
                    }

                    public String getRcmdShowType() {
                        return rcmdShowType;
                    }

                    public void setRcmdShowType(String rcmdShowType) {
                        this.rcmdShowType = rcmdShowType;
                    }

                    public static class MainTitleBean {
                        private String title;

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }
                    }

                    public static class ImageBean {
                        private String imageUrl;

                        public String getImageUrl() {
                            return imageUrl;
                        }

                        public void setImageUrl(String imageUrl) {
                            this.imageUrl = imageUrl;
                        }
                    }
                }

                public static class ResourcesBean {
                    private UiElementBean uiElement;
                    private String resourceType;
                    private Object resourceState;
                    private String resourceId;
                    private Object resourceUrl;
                    private ResourceExtInfoBean resourceExtInfo;
                    private String action;
                    private String actionType;
                    private boolean valid;
                    private String alg;
                    private String logInfo;
                    private Object ctrp;
                    private Object resourceContentList;

                    public UiElementBean getUiElement() {
                        return uiElement;
                    }

                    public void setUiElement(UiElementBean uiElement) {
                        this.uiElement = uiElement;
                    }

                    public String getResourceType() {
                        return resourceType;
                    }

                    public void setResourceType(String resourceType) {
                        this.resourceType = resourceType;
                    }

                    public Object getResourceState() {
                        return resourceState;
                    }

                    public void setResourceState(Object resourceState) {
                        this.resourceState = resourceState;
                    }

                    public String getResourceId() {
                        return resourceId;
                    }

                    public void setResourceId(String resourceId) {
                        this.resourceId = resourceId;
                    }

                    public Object getResourceUrl() {
                        return resourceUrl;
                    }

                    public void setResourceUrl(Object resourceUrl) {
                        this.resourceUrl = resourceUrl;
                    }

                    public ResourceExtInfoBean getResourceExtInfo() {
                        return resourceExtInfo;
                    }

                    public void setResourceExtInfo(ResourceExtInfoBean resourceExtInfo) {
                        this.resourceExtInfo = resourceExtInfo;
                    }

                    public String getAction() {
                        return action;
                    }

                    public void setAction(String action) {
                        this.action = action;
                    }

                    public String getActionType() {
                        return actionType;
                    }

                    public void setActionType(String actionType) {
                        this.actionType = actionType;
                    }

                    public boolean isValid() {
                        return valid;
                    }

                    public void setValid(boolean valid) {
                        this.valid = valid;
                    }

                    public String getAlg() {
                        return alg;
                    }

                    public void setAlg(String alg) {
                        this.alg = alg;
                    }

                    public String getLogInfo() {
                        return logInfo;
                    }

                    public void setLogInfo(String logInfo) {
                        this.logInfo = logInfo;
                    }

                    public Object getCtrp() {
                        return ctrp;
                    }

                    public void setCtrp(Object ctrp) {
                        this.ctrp = ctrp;
                    }

                    public Object getResourceContentList() {
                        return resourceContentList;
                    }

                    public void setResourceContentList(Object resourceContentList) {
                        this.resourceContentList = resourceContentList;
                    }

                    public static class UiElementBean {
                        private MainTitleBean mainTitle;
                        private ImageBean image;
                        private List<String> labelTexts;
                        private String rcmdShowType;

                        public MainTitleBean getMainTitle() {
                            return mainTitle;
                        }

                        public void setMainTitle(MainTitleBean mainTitle) {
                            this.mainTitle = mainTitle;
                        }

                        public ImageBean getImage() {
                            return image;
                        }

                        public void setImage(ImageBean image) {
                            this.image = image;
                        }

                        public List<String> getLabelTexts() {
                            return labelTexts;
                        }

                        public void setLabelTexts(List<String> labelTexts) {
                            this.labelTexts = labelTexts;
                        }

                        public String getRcmdShowType() {
                            return rcmdShowType;
                        }

                        public void setRcmdShowType(String rcmdShowType) {
                            this.rcmdShowType = rcmdShowType;
                        }

                        public static class MainTitleBean {
                            private String title;

                            public String getTitle() {
                                return title;
                            }

                            public void setTitle(String title) {
                                this.title = title;
                            }
                        }

                        public static class ImageBean {
                            private String imageUrl;

                            public String getImageUrl() {
                                return imageUrl;
                            }

                            public void setImageUrl(String imageUrl) {
                                this.imageUrl = imageUrl;
                            }
                        }
                    }

                    public static class ResourceExtInfoBean {
                        private long playCount;
                        private boolean highQuality;
                        private int specialType;

                        public long getPlayCount() {
                            return playCount;
                        }

                        public void setPlayCount(long playCount) {
                            this.playCount = playCount;
                        }

                        public boolean isHighQuality() {
                            return highQuality;
                        }

                        public void setHighQuality(boolean highQuality) {
                            this.highQuality = highQuality;
                        }

                        public int getSpecialType() {
                            return specialType;
                        }

                        public void setSpecialType(int specialType) {
                            this.specialType = specialType;
                        }
                    }
                }
            }
        }
    }
}
